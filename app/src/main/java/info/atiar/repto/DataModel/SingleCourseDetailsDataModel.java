package info.atiar.repto.DataModel;

public class SingleCourseDetailsDataModel {
    public String name;

    public static final String[] data = {"Cupcake", "Donut", "Eclair",
            "Froyo", "Gingerbread", "Honeycomb",
            "Icecream Sandwich", "Jelly Bean", "Kitkat", "Lollipop"};

    SingleCourseDetailsDataModel(String name){
        this.name=name;
    }
}
