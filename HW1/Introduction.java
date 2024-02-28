public class Introduction {

    public static void main(String[] args) {

        // Prints "Hello, World" in the terminal window.
        String name = "Phạm Ngọc Hải Dương";
        String id = "23021513";
        String classname = "QH-2023-I/CQ-CA3";
        String githubname = "Shiner-2";
        String vnumail = "23021513@vnu.edu.vn";
        String out1 = name + "\t" + id + "\t" + classname + "\t" + githubname + "\t" + vnumail;
        System.out.println(out1);
        for(int i = 9 ; i >= 1 ; i--){
            String num = Integer.toString(i);
            String output = num + " bottles of beer on the wall, " + num + " bottles of beer.";
            String output2 = "Take one down, pass it around,";
            System.out.println(output);
            System.out.println(output2);
        }
        System.out.println("No more bottles of beer on the wall.");

    }

}


