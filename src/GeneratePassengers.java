import java.io.FileWriter;
import java.io.IOException;

public class GeneratePassengers {

    public static void main(String[] args) throws IOException {
        String []firstNames ={"Asad","Benny", "Colin", "Donny", "Edward", "Freddy", "Greg", "Hal", "Ibrahim", "Jamie", "Kym", "liam", "Marvin", "Nicholas", "Oscar", "Quentin", "Richard", "Simon", "Thomas", "Ulysses", "Vinny", "William", "Xander", "Yves", "Zach","Agatha","Carol", "Beau", "Delia", "Ethal", "Fiona", "Georgina", "Holly", "India", "Joanna", "Kelly", "Leanne", "Michaela", "Niamh", "Olivia", "Queenie", "Rebecca", "Simone", "Tilly", "Ursula", "Violet", "Winifred", "Xanthe", "Yvonne", "Zara"};
        String [] secondNames ={"Ainsley", "Brown", "Chan", "Dappy", "English", "Firth", "Goodwin", "Holmes", "Iqbal", "Jameson", "Kantt", "Lingard", "Munster", "Nicoles", "Oscar", "Quest", "Reagan", "Shiffman", "Tolworth", "Underwood", "Venn", "Walsh", "Xeni", "Young", "Zerdin"};

        String [] classArray = {"economy", "economy","economy","first","first","first"};
        int [] holdBags = {1,1,1,1,1,2,2,3};

        int totalPassengers = 136;
        int maxFirstClass = 24;
        int crew = 7;
        String fileName = "flight7.txt";

        FileWriter fw = new FileWriter(fileName);

        for(int i = 0; i<totalPassengers; i++){
            String p = "passenger,";
            //name
            p += firstNames[(int) Math.floor(Math.random() * firstNames.length)] + " " +
                    secondNames[(int) Math.floor(Math.random() * secondNames.length)] + ",";
            //port number
            p += (int)(Math.floor(Math.random()*10000000)) + ",";
            String pc = classArray[(int) Math.floor(Math.random() * classArray.length)];
            if(pc.equals("first") && maxFirstClass > 0){
                p+= "first,";
                maxFirstClass--;
            }
            else{
                p +="economy,";
            }
            p += holdBags[(int) Math.floor(Math.random() * holdBags.length)] + "\n";
            fw.append(p);
        }

        for(int i = 0; i<crew; i++) {
            String p = "crew,";
            //name
            p += firstNames[(int) Math.floor(Math.random() * firstNames.length)] + " " +
                    secondNames[(int) Math.floor(Math.random() * secondNames.length)] + ",";
            //port number
            p += (int)(Math.floor(Math.random()*10000000)) + "\n";
            fw.append(p);
        }

        fw.close();

    }
}
