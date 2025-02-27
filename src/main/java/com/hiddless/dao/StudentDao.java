package com.hiddless.dao;

import com.hiddless.Main;
import com.hiddless.controller.StudentController;
import com.hiddless.dto.EStudentType;
import com.hiddless.dto.StudentDto;
import com.hiddless.exceptions.StudentNotFoundException;
import com.hiddless.util.SpecialColor;

import javax.swing.plaf.FileChooserUI;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class StudentDao implements IDaoGenerics<StudentDto> {

    /// Field
    private ArrayList<StudentDto> studentDtoList = new ArrayList<>();
    private int studentCounter = 0;
    private static final String FILE_NAME = "students.txt";

    /// ***Scanner zaten tanımlı
    private final Scanner scanner= new Scanner(System.in);

    /// Static
    static {

    }

    /// Parametresiz Constructor
    public StudentDao(){
        // Eğer students.txt yoksa otomatik oluştur
        createFileIfNotExists();

        // Program başlarken students.txt varsa
        loadStudentsListFromFile();
    }

    ////////////////////////////////////////////////////////////////
    // Login
    // Register

    /// /////////////////////////////////////////////////////////////
    // FileIO

    /// File If Not Exists (Eğer students.txt yoksa, oluştur)

    private void createFileIfNotExists(){
        //students.txt
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try {
                file.createNewFile();
                System.out.println(SpecialColor.BLUE+"Dosya Oluşturuldu."+SpecialColor.RESET);
            }catch (IOException ioException) {
                System.out.println(SpecialColor.RED + "Dosya oluşturulma Hatası"+SpecialColor.RESET);
                ioException.printStackTrace();
            }
        }
    }

    /// File Read
    /// Öğrenci Listesini Yükle (Dosya)
    private void saveToFile(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (StudentDto student : studentDtoList) {
                bufferedWriter.write(studentToCsv(student) + "\n");
            }
            System.out.println(SpecialColor.GREEN +"Öğrenciler dosyaya kaydedildi" +SpecialColor.RESET);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /// Öğrenciler dosyadan yükleme (BufferedReader)
    private void loadStudentsListFromFile() {
        //Listedeki verileri sıfırlamak için
        studentDtoList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while ((line = reader.readLine()) != null) {
                StudentDto student = csvToStudent(line);
                if (student != null) {
                    studentDtoList.add(student);
                }
            }
            //studentCounter = studentDtoList.size();
            studentCounter = studentDtoList.stream()
                    .mapToInt(StudentDto::getId)
                    .max()
                    .orElse(0);
            System.out.println(SpecialColor.PURPLE+ "Dosyadan yüklenen öğrenci sayısı: "+ studentCounter +SpecialColor.RESET);
        }catch (IOException e) {
            System.out.println(SpecialColor.RED+ "Dosya okumu hatası!"+ SpecialColor.RESET);
            e.printStackTrace();
        }
    }

    private String studentToCsv(StudentDto student) {
        return student.getId() + "," +          // Öğrenci ID'sini ekler
                student.getName() + "," +        // Öğrenci adını ekler
                student.getSurname() + "," +     // Öğrenci soyadını ekler
                student.getMidTerm() + "," +     // Öğrenci vize notunu ekler
                student.getFinalTerm() + "," +   // Öğrenci final notunu ekler
                student.getResultTerm() + "," +  // Öğrenci sonuç notunu ekler
                student.getBirthDate() + "," +   // Öğrenci doğum tarihini ekler
                student.geteStudentType();       // Öğrencinin eğitim türünü (Lisans, Yüksek Lisans vb.) ekler
    }

    private StudentDto csvToStudent(String csvLine) {
        try {
            String [] parts = csvLine.split(",");
            if (parts.length < 8) return null;

            return new StudentDto(
                    Integer.parseInt(parts[0]),
                    parts[1],
                    parts[2],
                    Double.parseDouble(parts[3]),
                    Double.parseDouble(parts[4]),
                    LocalDate.parse(parts[6]),
                    EStudentType.valueOf(parts[7])
           );
        }catch (Exception e) {
            // Eğer hata csv den kaynaklıysa hata mesajı verir
            System.out.println(SpecialColor.RED +"CSV'den öğrenci yükleme hatası!0" +SpecialColor.RESET);
            return null;
        }
    }

    /// ///////////////////////////////////////////////////////////
    //Öğrenci Ekle
    @Override
    public StudentDto create(StudentDto studentDto) {
        studentDto.setId(++studentCounter);
        studentDtoList.add(
                new StudentDto(studentDto.getId()-1, studentDto.getName(), studentDto.getSurname(),studentDto.getMidTerm(), studentDto.getFinalTerm(),studentDto.getBirthDate(),studentDto.geteStudentType())
        );
        System.out.println(SpecialColor.PURPLE+"Öğrenci Eklendi"+SpecialColor.RESET);
        saveToFile();
        return studentDto;
    }

    /// Öğrenci Listesi
    @Override
    public ArrayList<StudentDto> list (){
        if (studentDtoList.isEmpty()) {
            System.out.println(SpecialColor.RED + "Öğrenci Yokturç."+ SpecialColor.RESET);
            throw new StudentNotFoundException("Öğrenci Yoktur");
        }else {
            System.out.println(SpecialColor.PURPLE+ "Öğrenci Listesi"+SpecialColor.RESET);
            studentDtoList.forEach(System.out::println);
        }
        return studentDtoList;
    }

    //Öğrenci Ara
    @Override
    public StudentDto findByName(String name) {
        Optional<StudentDto> student = studentDtoList.stream()
                .filter(s-> s.getName().equalsIgnoreCase(name))
                .findFirst();
        return student.orElseThrow(() -> new StudentNotFoundException(name + SpecialColor.RED+ "İsimli Öğrenci bulunamadı."+ SpecialColor.RESET));
    }

    // Find By Id
    @Override
    public StudentDto findById(int id) {
        return null;
    }

    // Öğrenci Güncelle
    @Override
    public StudentDto update(int id, StudentDto studentDto) {
        for (StudentDto temp : studentDtoList) {
            if (temp.getId() == id) {
                temp.setName(studentDto.getName());
                temp.setSurname(studentDto.getSurname());
                temp.setBirthDate(studentDto.getBirthDate());
                temp.setMidTerm(studentDto.getMidTerm());
                temp.setFinalTerm(studentDto.getFinalTerm());
                temp.seteStudentType(studentDto.geteStudentType());

                System.out.println(SpecialColor.CYAN+"Öğrenci Verileri Başarıyla Güncellendi"+SpecialColor.RESET);
                saveToFile();
                return temp;
            }
        }
        throw new StudentNotFoundException(SpecialColor.RED+"Öğrenci Bulunamadı"+SpecialColor.RESET);
    }

    //Öğrenci Sil
    @Override
    public StudentDto delete(int id) {
        boolean removed = studentDtoList.removeIf(temp -> temp.getId() == id);
        if (removed) {
            System.out.println(SpecialColor.CYAN+"Öğrenci Silindi"+ SpecialColor.RESET);
            saveToFile();
            return null;
        }else {
            System.out.println(SpecialColor.RED+ "Öğrenci Silinemedi"+ SpecialColor.RESET);
            throw new StudentNotFoundException("Öğrenci silinemedi, ID bulunamadı");
        }
    }

    //////////////////////////////////////////////////////////////
    //Enum Öğrenci Türü
    public EStudentType studentTypeMethod(){
        System.out.println("Öğrenci türünü seçiniz. \n1-)Lisans\n2-)Yüksek Lisans\n3-)Doktora");
        int typeChooise = scanner.nextInt();
        EStudentType switchCaseStudent = switch (typeChooise) {
            case 1 -> EStudentType.UNDERGRADUATE;
            case 2 -> EStudentType.GRADUATE;
            case 3 -> EStudentType.PHD;
            default -> EStudentType.OTHER;
        };
        return switchCaseStudent;
    }

    ////////////////////////////////////////////////////////////////

    // Console Seçim Öğrenci
    @Override
    public void chooise() {
        while (true){
            System.out.println("\n===== ÖĞRENCİ YÖNETİM SİSTEMİ =====");
            System.out.println("1. Öğrenci Ekle");
            System.out.println("2. Öğrenci Listele");
            System.out.println("3. Öğrenci Ara");
            System.out.println("4. Öğrenci Güncelle");
            System.out.println("5. Öğrenci Sil");
            System.out.println("6. Toplam Öğrenci Sayısı");
            System.out.println("7. Rastgele Öğrenci Seç");
            System.out.println("8. Öğrenci Not Ortalaması Hesapla");
            System.out.println("9. En Yüksek & En Düşük Not Alan Öğrenci");
            System.out.println("10. Öğrencileri Doğum Tarihine Göre Sırala");
            System.out.println("11. Çıkış");
            System.out.print("Seçiminizi yapınız: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> { //Öğrenci Ekle
                    chooiseStudentAdd();
                }
                case 2 -> { //Öğrenci Listeleme
                    chooiseStudentList();
                }
                case 3 -> { //Öğrenci Arama
                    chooiseStudentSearch();
                }
                case 4 -> { //Öğrenci Güncelleme
                    chooiseStudentUpdate();
                }
                case 5 -> { //Öğrenci Sil
                    chooiseStudentDelete();
                }
                case 6 -> { //Toplam Öğrenci Sayısı
                    chooiseSumCounter();
                }
                case 7 ->{ //Random Öğrenci
                    chooiseRandomStudent();
                }
                case 8 ->{
                    chooiseStudentNoteAverage();
                }
                case 9 -> { // En Yüksek & En Düşük Not Alan Öğrenci
                    chooiseStudentNoteMinAndMax();
                }
                case 10 -> { // Öğrencileri Doğum Tarihine Göre Sırala
                    chooiseStudentBirthdaySortedDate();
                }
                case 11 -> { // Çıkış
                    chooiseExit();
                }
                default -> System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
            }
        }
    } // end chooise

    ///  Student Add
    public void chooiseStudentAdd(){
        System.out.println("Öğrenci Adı: ");
        String name = scanner.nextLine();

        System.out.println("Öğrenci Soyadı: ");
        String surname = scanner.nextLine();

        System.out.println("Doğum Tarihi (DD-MM-YYYY): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Vize Notu: ");
        double midTerm = scanner.nextDouble();

        System.out.println("Final Notu: ");
        double finalTerm = scanner.nextDouble();

        EStudentType studentType = studentTypeMethod();
        StudentDto newStudent = new StudentDto(++studentCounter, name, surname, midTerm, finalTerm, birthDate,studentType);
        create(newStudent);
        System.out.println("Öğrenci başarıyla eklendi");
    }

    /// Student List
    public void chooiseStudentList() {
        try {
            //list().forEach(System.out::println);
            list();
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /// Student Search
    public void chooiseStudentSearch(){
        list();
        System.out.println("Aranacak Öğrenci Adı: ");
        String searchName = scanner.nextLine();
        try {
            System.out.println(findByName(searchName));
        }catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /// Student Update
    public void chooiseStudentUpdate(){
        list();
        System.out.println("Güncellenecek Öğrenci ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Yeni Adı: ");
        String nameUpdate = scanner.nextLine();

        System.out.println("Yeni Soyadı: ");
        String surnameUpdate = scanner.nextLine();

        System.out.println("Doğum Tarihi (DD-MM-YYYY)");
        LocalDate birthDateUpdate = LocalDate.parse(scanner.nextLine());

        System.out.println("Yeni Vize Notu: ");
        double midTermUpdate = scanner.nextDouble();

        System.out.println("Yeni Final Notu: ");
        double finalTermUpdate = scanner.nextDouble();

        StudentDto studentUpdate = new StudentDto(id, nameUpdate, surnameUpdate, midTermUpdate, finalTermUpdate, birthDateUpdate,studentTypeMethod());
        try {
            update(id, studentUpdate);
            System.out.println("Öğrenci Başarıyla güncellendi.");
        }catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /// Student Delete
    public void chooiseStudentDelete() {
        list();
        System.out.println("Silinecek Öğrenci ID: ");
        int deleteID = scanner.nextInt();
        try {
            delete(deleteID);
            System.out.println("Öğrenci Başarıyla Silinmiştir.");
        }catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /// Student Sum Counter
    public void chooiseSumCounter() {
        System.out.println("Toplam Öğrenci Sayısı: "+ studentDtoList.size());
    }

    /// Student Random
    public void chooiseRandomStudent() {
        if (!studentDtoList.isEmpty()){
            StudentDto randomStudent = studentDtoList.get((int) (Math.random() * studentDtoList.size()));
            System.out.println("Rastegele Seçilen öğrenci: " + randomStudent);
        }else {
            System.out.println(SpecialColor.RED+"Rastgele Öğrenci Bulunamadı"+SpecialColor.RESET);
        }
    }

    /// Öğrenci Not ortalamsı Hesapla
    public void chooiseStudentNoteAverage() {
        if (!studentDtoList.isEmpty()){
            double avg = studentDtoList.stream()
                    .mapToDouble(StudentDto::getResultTerm)
                    .average()
                    .orElse(0.0);
        }else {
            System.out.println("Öğrenci Listesi Boş.");
        }
    }

    /// En yüksek & En Düşük Not alan öğrenci
    public void chooiseStudentNoteMinAndMax() {
        if (!studentDtoList.isEmpty()) {
            StudentDto maxStudent = studentDtoList.stream()
                    .max((s1, s2) -> Double.compare(s1.getResultTerm(),s2.getResultTerm()))
                    .orElse(null);

            StudentDto minStudent = studentDtoList.stream()
                    .min((s1, s2) -> Double.compare(s1.getResultTerm(),s2.getResultTerm()))
                    .orElse(null);

            System.out.println("En yüksek Puan alan öğrenci: " + maxStudent);
            System.out.println("En düşük Puan alan öğrenci: " + minStudent);
        }else {
            System.out.println("Liste Boş");
        }
    }

    /// Öğrencileri Doğum Tarihine göre sırala
    public void chooiseStudentBirthdaySortedDate(){
        studentDtoList.stream()
                .sorted((s1, s2) -> s1.getBirthDate().compareTo(s2.getBirthDate()))
                .forEach(System.out::println);
    }

    public void chooiseExit() {
        System.out.println("Sistemden çıkılıyor...");
        scanner.close();
        return;
    }
}
