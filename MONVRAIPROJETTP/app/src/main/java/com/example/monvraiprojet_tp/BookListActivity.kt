package com.example.monvraiprojet_tp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.ktx.firestore
import kotlinx.android.synthetic.main.booklist.*


import kotlin.math.log

class Book(auteur:String,description:String,date_de_parution:String,titre:String,id:String){
    var auteur:String = auteur;
    var description:String? = description;
    var date_de_parution:String? = date_de_parution;
    var titre:String? = titre;
    var id:String? = id;
}


class BookListActivity: AppCompatActivity() {
    private val db = Firebase.firestore
    val list = mutableListOf<Book>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.booklist)


        db.collection("Livre")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    //Log.d(TAG, "JE SUIS LES LIVRES :"+"${document.id} => ${document.data}")
                    list.add(Book(document.data["Auteur"].toString(),document.data["Description"].toString(),document.data["date de parution"].toString(),document.data["Nom"].toString(),document.id))
                }
                for (document in list) {
                    Log.d(TAG, "JE SUIS LES LIVRES :"+"${document.titre}")
                }
                (BookRecyclerView.adapter as Adaptor).run {  }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }



    }





    /*get.addOnSuccessListener { result ->
    // QuerrySnapshot
    }

    get.addOncompleteListener {task ->
    // Task<QuerySnapshot>
        task.result
    }*/
}

