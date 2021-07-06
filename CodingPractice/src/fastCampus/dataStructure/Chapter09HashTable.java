package fastCampus.dataStructure;


import fastCampus.dataStructure.util.Slot;

public class Chapter09HashTable {
    public Slot[] hashTable;

    public Chapter09HashTable(int size){
        this.hashTable = new Slot[size];
    }

    public int hashFunction(String key){
        // 주소의 정의 : key 첫번째 문자의 아스키값을 슬롯의 길이로 나눈 나머지 값이다.
        return (int)(key.charAt(0)) % this.hashTable.length;
    }


    public boolean saveData(String key, String value){
        int addr = this.hashFunction(key);
        if(this.hashTable[addr] != null){
            // Chaining 기법 - Open Hashing 기법
            /*
            Slot current = this.hashTable[addr];
            Slot prev = this.hashTable[addr];
            while(current != null){
                if(current.key == key){
                    current.value = value;
                    return true;
                }else{
                    prev = current;
                    current = current.next;
                }
            }
            prev.next = new Slot(key, value);
            */

            // Chaining 기법 - Close Hashing 기법
            int currentAddr = addr + 1;
            while (this.hashTable[currentAddr] != null){
                if(this.hashTable[currentAddr].key == key){
                    this.hashTable[currentAddr].value = value;
                    return true;
                }else{
                    currentAddr++;
                    if(currentAddr >= this.hashTable.length){
                        return false;
                    }
                }
            }
            this.hashTable[currentAddr] = new Slot(key, value);
        }else{
            this.hashTable[addr] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key){
        int addr = this.hashFunction(key);
        if(this.hashTable[addr] != null){
            // Chaining 기법 - Open Hashing 기법
            /*
            Slot current = this.hashTable[addr];
            while (current != null){
                if(current.key == key){
                    return current.value;
                }else{
                    current = current.next;
                }
            }
            return null;
            */

            // Chaining 기법 - Close Hashing 기법
            int currentAddr = addr;
            while (this.hashTable[currentAddr] != null){
                if(this.hashTable[currentAddr].key == key){
                    return this.hashTable[currentAddr].value;
                }else{
                    currentAddr++;
                    if(currentAddr >= this.hashTable.length){
                        return null;
                    }
                }
            }
            return this.hashTable[currentAddr].value;
        }else{
            return null;
        }
    }



    public static void main (String [] args){
        Chapter09HashTable mainObject = new Chapter09HashTable(20);
        mainObject.saveData("DaveLee", "01022223333");
        mainObject.saveData("fun-coding", "01033334444");
        mainObject.saveData("David", "01044445555");
        mainObject.saveData("Dave", "01055556666");

        System.out.println(mainObject.getData("DaveLee"));
        System.out.println(mainObject.getData("David"));
        System.out.println(mainObject.getData("Dave"));

    }

}
