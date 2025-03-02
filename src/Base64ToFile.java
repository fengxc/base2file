import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Base64ToFile {

    public static void decodeBase64ToFile(String base64Text, String filePath) {
        String split = "base64,";

        // 解码Base64字符串
        String pureBase64Text = base64Text.split(split)[1];
        byte[] bytes = Base64.getDecoder().decode(pureBase64Text);
        try (FileOutputStream imageOutFile = new FileOutputStream(filePath)) {

            // 将解码后的字节数据写入图片文件
            imageOutFile.write(bytes);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        String inPath = "E:\\syncshare\\2.txt";
        String outPath = "E:\\syncshare\\out2.7z";

        String base64Image = Files.readString(Paths.get(inPath));;
        decodeBase64ToFile(base64Image, outPath);
    }
}