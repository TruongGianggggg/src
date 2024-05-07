package bai6;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class recordFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Đọc file");
            System.out.println("2. Ghi file");
            System.out.println("3. Sao chép file");
            System.out.println("4. Xóa file");
            System.out.println("5. Tạo mới file");
            System.out.println("6. Đổi tên file");
            System.out.println("7. Thoát");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    readFile(scanner);
                    break;
                case 2:
                    writeFile(scanner);
                    break;
                case 3:
                    copyFile(scanner);
                    break;
                case 4:
                    deleteFile(scanner);
                    break;
                case 5:
                    createFile(scanner);
                    break;
                case 6:
                    renameFile(scanner);
                    break;
                case 7:
                    System.out.println("Đã thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }



    private static void readFile(Scanner scanner) {
        System.out.println("Nhập đường dẫn của file:");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        try {
            String content = new String(Files.readAllBytes(file.toPath()));
            System.out.println("Nội dung của file:");
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
    private static void writeFile(Scanner scanner) {
        System.out.println("Nhập đường dẫn của file:");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File không tồn tại.");
            return;
        }

        if (!file.canWrite()) {
            System.out.println("Không thể ghi vào file.");
            return;
        }

        System.out.println("Nhập nội dung để ghi vào file:");
        String content = scanner.nextLine();

        try {
            Files.write(file.toPath(), content.getBytes());
            System.out.println("Ghi file thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }


    private static void copyFile(Scanner scanner) {
        System.out.println("Nhập đường dẫn nguồn:");
        String sourcePath = scanner.nextLine();

        System.out.println("Nhập đường dẫn đích:");
        String destPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Sao chép file thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi sao chép file: " + e.getMessage());
        }
    }

    private static void deleteFile(Scanner scanner) {
        System.out.println("Nhập đường dẫn của file cần xóa:");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Xóa file thành công.");
            } else {
                System.out.println("Không thể xóa file.");
            }
        } else {
            System.out.println("File không tồn tại.");
        }
    }

    private static void createFile(Scanner scanner) {
        System.out.println("Nhập đường dẫn của file mới:");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        try {
            if (file.createNewFile()) {
                System.out.println("Tạo mới file thành công.");
            } else {
                System.out.println("File đã tồn tại.");
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi tạo mới file: " + e.getMessage());
        }
    }

    private static void renameFile(Scanner scanner) {
        System.out.println("Nhập đường dẫn của file cần đổi tên:");
        String oldFilePath = scanner.nextLine();

        System.out.println("Nhập tên mới:");
        String newFileName = scanner.nextLine();

        File oldFile = new File(oldFilePath);
        File newFile = new File(oldFile.getParent() + File.separator + newFileName);

        if (oldFile.exists()) {
            if (oldFile.renameTo(newFile)) {
                System.out.println("Đổi tên file thành công.");
            } else {
                System.out.println("Không thể đổi tên file.");
            }
        } else {
            System.out.println("File không tồn tại.");
        }
    }
}

///Users/macbook/Baitapctdl/HuongDoiTuong/out/production/Directory_1/Vidu1.txt
///Users/macbook/Baitapctdl/HuongDoiTuong/out/production/Directory_2
///Users/macbook/Baitapctdl/HuongDoiTuong/out/production/Vidu3.txt
///vidu1.txt

