package com.example.junghyun.mt;

import android.view.View;

import java.util.ArrayList;

/**
 * Simple POJO model for example
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Item {


    private String title;
    private int id;
    private String date;
    private String location;
    private int people;
    private int price;

    private View.OnClickListener requestBtnClickListener;

    public Item() {
    }

    public Item(String title, int id, String date, String location, int people, int price) {
        this.title = title;
        this.id = id;
        this.date = date;
        this.location = location;
        this.people=people;
        this.price=price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener;
    }

    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener = requestBtnClickListener;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        if (people != item.people) return false;
        if (price != item.price) return false;
        if (title != null ? !title.equals(item.title) : item.title != null)
            return false;
        if (date != null ? !date.equals(item.date) : item.date != null)
            return false;
        return !(location != null ? !location.equals(item.location) : item.location != null);

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + people;
        result = 31 * result + price;
        return result;
    }

    /**
     * @return List of elements prepared for tests
     */
    public static ArrayList<Item> getTestingList() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("레드카드 MT",1, "2018.03.24~2018.03.25", "솔거펜션",50, 30000));
        items.add(new Item("11학번 동기엠티",2, "2018.03.24~2018.03.25", "일영의집",25, 35000));
        items.add(new Item("수학과 총엠티",3, "2018.03.24~2018.03.25", "참누리아파트",120, 20000));
        items.add(new Item("그냥엠티",4, "2018.03.24~2018.03.25", "과방펜션",60, 60000));
        items.add(new Item("11학번 동기엠티",2, "2018.03.24~2018.03.25", "일영의집",25, 35000));
        return items;

    }

}
