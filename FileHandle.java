package Calculator;

import java.io.*;

public class FileHandle {
    static String fileName = "answer.txt"; // 存儲文件地址
     // 将正确结果写入文件
     public static void answerSave(String input, String output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.write(input + "=" + output);
        writer.newLine();
        writer.close();
    }

    // 清空文档
    public static void clearFile(String fileName) throws IOException {
        File file = new File(fileName);
        file.delete();
        file.createNewFile();
    }
}
