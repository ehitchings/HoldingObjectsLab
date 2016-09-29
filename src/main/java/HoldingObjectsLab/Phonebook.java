package HoldingObjectsLab;
import java.util.TreeMap;
import java.util.Map;

/**
 * Created by evanhitchings on 9/29/16.
 */
public class Phonebook {
    private Map<String, String> book;

    public Phonebook(){
        this.book = new TreeMap<String, String>();
    }

    public Map<String, String> getBook() {
        return book;
    }

    public void add(String name, String number){
        this.book.put(name, number);
    }

    public String lookup(String nameToFind){
        for (String name: book.keySet()){
            if (name.equalsIgnoreCase(nameToFind)){
                return book.get(name);
            }
        }
        return null;
    }

    public void remove(String name){
        this.book.remove(name);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(this.getBook().size());
        for(String name : book.keySet()){
            sb.append(name +"\t" + book.get(name) + "\n" );

        }
        return sb.toString();
    }

    public String reverseLookup(String number){
        for(String name : book.keySet()){
            if (book.get(name).equalsIgnoreCase(number)){
                return name;
            }
        }
        return null;
    }
}
