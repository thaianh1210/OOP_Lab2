public class ConcatenationInLoops {
    public static void main(String[] args) {
        // Sử dụng Random để tạo số ngẫu nhiên
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        // Sử dụng String với toán tử +
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2); // Nối thêm số ngẫu nhiên (0 hoặc 1)
        }
        System.out.println(System.currentTimeMillis() - start); // In thời gian thực hiện
        // Reset Random để đảm bảo kết quả tương tự
        r = new Random(123);
        start = System.currentTimeMillis();
        // Sử dụng StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2)); // Append số ngẫu nhiên (0 hoặc 1)
        }
        s += sb.toString();
        System.out.println(System.currentTimeMillis() - start); // In thời gian thực hiện
    }
}
