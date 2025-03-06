package com.hiddless;

import com.hiddless.controller.StudentController;
import com.hiddless.controller.TeacherController;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Scanner
    private static final Scanner scanner = new Scanner(System.in);

    // CHOOISE
    private static void chooise() {
        while (true) {
            try {
                System.out.println("\n===== ÖĞRETMEN YÖNETİM SİSTEMİ =====");
                System.out.println("1. Öğretmen Ekle");
                System.out.println("2. Öğrenci Ekle");
                System.out.println("3. Çıkış");
                System.out.print("\nSeçiminizi yapınız: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Boşluğu temizleme

                switch (choice) {
                    case 1 -> teacher();
                    case 2 -> student();
                    case 3 -> {
                        System.out.println("Çıkış yapılıyor...");
                        return;
                    }
                    default -> System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
                }
            } catch (Exception e) {
                System.out.println("⛔ Beklenmeyen bir hata oluştu: " + e.getMessage());
                scanner.nextLine(); // Scanner'ı temizle
            }
        }
    }

    // STUDENT
    private static void student() {
        try {
            StudentController studentController = new StudentController();
            studentController.chooise();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TEACHER
    private static void teacher() {
        try {
            TeacherController teacherController= new TeacherController();
            //TeacherDao teacherDao = new TeacherDao();
            //teacherDao.chooise();
            teacherController.chooise();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // PSVM
    public static void main(String[] args) {
        chooise();
    } //end psvm
} // Main