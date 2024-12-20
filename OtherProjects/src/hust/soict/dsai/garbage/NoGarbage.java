public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\Admin\\Desktop\\Github Desktop\\OOP_Lab2\\OtherProjects\\src\\hust\\soict\\dsai\\garbage.test.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder("");
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
