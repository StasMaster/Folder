public class NameEncoderDecoder{
    public String encode(String name){
        name = name.replace("e", "1");
        name = name.replace("u", "2");
        name = name.replace("i", "3");
        name = name.replace("o", "4");
        name = name.replace("a", "5");
         return "NOTFORYOU" + name + "YESNOTFORYOU";
    }
    public String decode(String name) {
            return name
                    .replace("1", "e")
                    .replace("2", "u")
                    .replace("3", "i")
                    .replace("4", "o")
                    .replace("5", "a")
                    .replace("YESNOTFORYOU", "")
                    .replace("NOTFORYOU", "")
                    .replace("NOTFOR", "NOTFORYOU");
    }
    public static void main(String[] args) {
        NameEncoderDecoder ned = new NameEncoderDecoder();
        System.out.println(ned.encode("Crab"));
        System.out.println(ned.decode("NOTFORYOUCr5bYESNOTFORYOU"));
        System.out.println(ned.decode("NOTFOR"));
    }
}