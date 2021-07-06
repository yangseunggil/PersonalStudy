package fastCampus.dataStructure.util;

public class Slot {
    public String value;

    /* Chaining 기법 - Open Hashing 기법, Close Hashing 기법
     * 동일한 Hash값이 있다면 그 위치에 대한 링크드 리스트를 생성하여 데이터를 저장
     */
    public String key;


    public Slot next; // Close Hashing 기법에서는 미사용



    public Slot(String value){
        this.value = value;
    }
    public Slot(String key, String value){
        this.key = key;
        this.value = value;
    }
}
