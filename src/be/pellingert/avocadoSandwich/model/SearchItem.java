package be.pellingert.avocadoSandwich.model;

/**
 * Created by gp on 4/06/15.
 */
public class SearchItem implements Comparable{
    private String searchString;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public int getId() {
        return id;
    }

    public String getSearchString() {
        return searchString;
    }

    @Override
    public String toString() {
        return searchString;
    }

    public SearchItem(String searchString, int id) {
        this.searchString = searchString;
        this.id = id;
    }


    @Override
    public int compareTo(Object item) {
        String compareSearchString = ((SearchItem) item).getSearchString();

        //ascending order
        return this.searchString.compareTo(compareSearchString);

        //descending order
        //return compareQuantity - this.quantity;
    }
}
