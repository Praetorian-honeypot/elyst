package com.sybiload.elyst;

import android.content.Context;
import android.content.SharedPreferences;

import com.sybiload.elyst.Adapter.AdapterAdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class List
{
    private String name;
    private String description;
    private String idDb;
    private Calendar reminder;
    private int background;
    public static ArrayList<Item> itemShop;
    public static ArrayList<Item> itemAvailable;

    public List(String idDb, String name, String description, Calendar reminder, int background)
    {
        this.idDb = idDb;
        this.name = name;
        this.description = description;
        this.reminder = reminder;
        this.background = background;
        itemShop = new ArrayList<Item>();
        itemAvailable = new ArrayList<Item>();
    }

    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return this.description;
    }
    public void setDescription (String description)
    {
        this.description= description;
    }

    public String getIdDb()
    {
        return this.idDb;
    }
    public void setIdDb(String idDb)
    {
        this.idDb = idDb;
    }

    public Calendar getReminder()
    {
        return this.reminder;
    }
    public void setReminder(Calendar reminder)
    {
        this.reminder = reminder;
    }

    public int getBackground()
    {
        return this.background;
    }
    public void setBackground(int background)
    {
        this.background = background;
    }


    // sort item in alphabetical order
    public void sortShop(Context ctx)
    {
        SharedPreferences mainPref = ctx.getApplicationContext().getSharedPreferences("main", 0);

        if (mainPref.getString("listPreferenceUiShopSort", "alphabetical").equals("alphabetical"))
        {
            Collections.sort(itemShop, new Comparator<Item>()
            {
                public int compare(Item v1, Item v2) {
                    return v1.getName().compareTo(v2.getName());
                }
            });
        }
        else if (mainPref.getString("listPreferenceUiShopSort", "alphabetical").equals("category"))
        {
            Collections.sort(itemShop, new Comparator<Item>()
            {
                public int compare(Item v1, Item v2) {
                    return Integer.toString(v1.getCategory()).compareTo(Integer.toString(v2.getCategory()));
                }
            });
        }
    }

    // sort item in alphabetical order
    public void sortAvailable(Context ctx)
    {
        SharedPreferences mainPref = ctx.getApplicationContext().getSharedPreferences("main", 0);

        if (mainPref.getString("listPreferenceUiAddSort", "alphabetical").equals("alphabetical"))
        {
            Collections.sort(itemAvailable, new Comparator<Item>()
            {
                public int compare(Item v1, Item v2) {
                    return v1.getName().compareTo(v2.getName());
                }
            });
        }
        else if (mainPref.getString("listPreferenceUiAddSort", "alphabetical").equals("category"))
        {
            Collections.sort(itemAvailable, new Comparator<Item>()
            {
                public int compare(Item v1, Item v2) {
                    return Integer.toString(v1.getCategory()).compareTo(Integer.toString(v2.getCategory()));
                }
            });
        }
    }

    // sort item in alphabetical order
    public void sortShopDone()
    {
        Collections.sort(itemShop, new Comparator<Item>()
        {
            public int compare(Item v1, Item v2) {
                return v1.getDone().compareTo(v2.getDone());
            }
        });
    }
}