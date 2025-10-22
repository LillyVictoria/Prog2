import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NameGenerator {
    private final List<String> firstNames;
    private final List<String> lastNames;
    private final List<String> particles;
    private final Random random;

    public NameGenerator(String filePath) throws FileNotFoundException {
        firstNames = new ArrayList<>();
        lastNames = new ArrayList<>();
        particles = new ArrayList<>();
        random = new Random();
        readNameFile(filePath);
    }
    public String next() {
        StringBuilder name = new StringBuilder();
        name.append(firstNames.get((int) (random.nextDouble() * (firstNames.size()))));
        name.append(" ");
        if(random.nextBoolean()) {
            name.append(particles.get((int) (random.nextDouble() * (particles.size()))));
            name.append(" ");
        }
        name.append(lastNames.get((int) (random.nextDouble() * (lastNames.size()))));
        return name.toString();
    }

    private void readNameFile(String filePath) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filePath));
        parseNameFile(in);
        in.close();
    }

    private void parseNameFile(Scanner nameScanner) {
        NameElement currentList = NameElement.FirstName;
        while(nameScanner.hasNext()) {
            String nextItem = nameScanner.next();
            switch(nextItem) {
                case "FirstNames" : {
                    currentList = NameElement.FirstName;
                    break;
                }
                case "LastNames" : {
                    currentList = NameElement.LastName;
                    break;
                }
                case "Particles" : {
                    currentList = NameElement.Particle;
                    break;
                }
                default : {
                    switch(currentList) {
                        case NameElement.FirstName : {
                            firstNames.add(nextItem);
                            break;
                        }
                        case NameElement.LastName : {
                            lastNames.add(nextItem);
                            break;
                        }
                        case NameElement.Particle : {
                            particles.add(nextItem);
                            break;
                        }
                    }
                }
            }
        }
    }

    private enum NameElement {
        FirstName,
        LastName,
        Particle
    }
}
