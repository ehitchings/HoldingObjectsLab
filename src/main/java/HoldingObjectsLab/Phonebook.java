package HoldingObjectsLab;
import java.util.TreeMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by evanhitchings on 9/29/16.
 */
public class Phonebook {
    private Map<String, ArrayList<String>> book;

    public Phonebook(){
        this.book = new TreeMap<String, ArrayList<String>>();
    }

    public Map<String, ArrayList<String>> getBook() {
        return book;
    }

    public void add(String name, String number){
        if(this.book.containsKey(name)) {
            this.addNumberToExistingEntry(name, number);
        } else{
            this.addNewEntry(name, number);
        }

    }

    private void addNumberToExistingEntry(String name, String number){
        this.book.get(name).add(number);

    }

    private void addNewEntry(String name, String number){
        ArrayList<String> toAdd = new ArrayList<String>();
        toAdd.add(number);
        this.book.put(name, toAdd);

    }

    public List<String> lookup(String nameToFind){
        for (String name: book.keySet()){
            if (name.equalsIgnoreCase(nameToFind)){
                return book.get(name);
            }
        }
        return null;
    }



    public void removeRecord(String name){
        this.book.remove(name);
    }

    public void removeNumber(String name, String number){
        this.lookup(name).remove(number);
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
            if (book.get(name).contains(number)){
                return name;
            }
        }
        return null;
    }
}
