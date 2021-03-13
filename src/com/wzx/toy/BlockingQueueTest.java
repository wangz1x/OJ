package com.wzx.toy;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlockingQueueTest {

    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREAD_NUM = 33;
    private static final Path DUMMY = Paths.get("");
    private static final BlockingQueue<Path> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) throws IOException {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        Path p = Paths.get("/home/wangzx/IdeaProjects/OJ");
        scanFile1(list1, p);
        scanFile2(list2, p);

        System.out.println(list1.size());
        System.out.println("====================================================================================");
        System.out.println(list2.size());
    }

    public static void scanFile1(List<String> files, Path path) throws IOException {
        if (Files.isDirectory(path)) {
            for (Path p : Files.list(path).collect(Collectors.toList())) {
                scanFile1(files, p);
            }
        } else {
            files.add(path.toString());
        }
    }

    public static void scanFile2(List<String> files, Path path) throws IOException {
        for (Path p : Files.walk(path).collect(Collectors.toList())) {
            if (!Files.isDirectory(p))
                files.add(p.toString());
        }
    }

    public static void scanFileFindKeyword() {
        try (Scanner scanner = new Scanner(System.in);) {
            System.out.println("Enter search root directory (e.g. /opt/jdk-8-src): ");
            String directory = scanner.nextLine();
            System.out.println("Enter keyword: ");
            String keyword = scanner.nextLine();

            new Thread(() -> {
                try {
                    enumerate(Paths.get(directory));
                    for (int i = 0; i < SEARCH_THREAD_NUM; i++)
                        queue.put(DUMMY);
                    System.out.println("all files have been put into queue");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            for (int i = 0; i < SEARCH_THREAD_NUM; i++) {
                new Thread(() -> {
                    boolean done = false;
                    while (!done) {
                        try {
                            Path path = queue.take();
                            if (path == DUMMY) done = true;
                            else search(path, keyword);
                        } catch (InterruptedException | IOException ignored) {
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " has finished work ...");
                }).start();
            }
        }
    }

    public static void enumerate(Path directory) throws InterruptedException {
        try (Stream<Path> children = Files.list(directory)) {
            for (Path child : children.collect(Collectors.toList())) {
                if (Files.isDirectory(child)) {
                    enumerate(child);
                } else {
                    queue.put(child);
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void search(Path path, String keyword) throws IOException {
//        path.toFile().getName();
        try (Scanner file = new Scanner(path, String.valueOf(StandardCharsets.UTF_8));) {
            int lineNum = 0;
            while (file.hasNextLine()) {
                lineNum++;
                String line = file.nextLine();
                if (line.contains(keyword)) {
                    System.out.println(path + ":::" + lineNum + ":::" + line);
                }
            }
        }
    }
}
