package com.masai.myjournalapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DatabaseHandler(val context: Context) :
    SQLiteOpenHelper(context, "journalbd", null, 1) {

    companion object{
        val TABLE_NAME = "journal_table"
        val ID = "id"
        val TITLE = "title"
        val DESC = "desc"
        val DAY = "day"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        val createQuery = "CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY," +
                " $TITLE TEXT, $DESC TEXT, $DAY TEXT)"

        db?.execSQL(createQuery)

    }


    fun insertRoutine(title: String, desc: String, day : String){

        val db = writableDatabase

        val values = ContentValues()
        values.put(TITLE, title)
        values.put(DESC, desc)
        values.put(DAY, day)

        val id = db.insert(TABLE_NAME, null, values)

        if (id.toInt() == -1){
            //Error
            Toast.makeText(context, "Error, data not inserted", Toast.LENGTH_SHORT).show()
        }else{
            //Success
            Toast.makeText(context, "Data not inserted successfully", Toast.LENGTH_SHORT).show()
        }

    }

    fun updateRoutine(id : Int, newTitle: String, newDesc: String, newDay: String){
        val db = writableDatabase

        //update routine where id=1 titel.....
        val values = ContentValues()
        //values.put(ID, id)
        values.put(TITLE, newTitle)
        values.put(DESC, newDesc)
        values.put(DAY, newDay)

        val affectedRows = db.update(TABLE_NAME, values, "id = $id", null)

        if (affectedRows > 0){
            //Success
            Toast.makeText(context, "Data Updated successfully", Toast.LENGTH_SHORT).show()

        }else{
            //Failed
            Toast.makeText(context, "Error, data not updated", Toast.LENGTH_SHORT).show()

        }
    }

    fun deleteRoutine(id : Int){
        val db = writableDatabase

        val affectedRows = db.delete(TABLE_NAME, "id = $id", null)

        if (affectedRows > 0){
            //Success
            Toast.makeText(context, "Data Dleted successfully", Toast.LENGTH_SHORT).show()

        }else{
            //Failed
            Toast.makeText(context, "Error, data not deleted", Toast.LENGTH_SHORT).show()

        }

    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {


    }
}