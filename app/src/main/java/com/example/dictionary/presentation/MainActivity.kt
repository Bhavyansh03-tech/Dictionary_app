package com.example.dictionary.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.dictionary.ui.theme.DictionaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DictionaryTheme {
                // A surface container using the 'background' color from the theme.
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Working on MVVM :-> Add Internet Permission.
                    // CREATE DATA, DI AND DOMAIN PACKAGES TO WORK ON MVVM :->
                    // 1.> First we create DTO's (Data Transfer Object), to convert json to data.
                    // 2.> Creating Api and then Di (Dependency injection) using dagger-hilt.
                    // 3.> Create sealed class name as result for flow in repo.
                    // 4.> Now create new package name it domain and create repository.
                    // 5.> Now create model class in domain package.
                    // 6.> Now create mapper in data package to convert dto into data model for view model.
                    // 7.> Create new class and extend with application and add in manifest.
                    // 8.> Now create repository impl. in data package.
                    // 9.> Now create repository module as an abstract class in di.
                    // NOW CREATE NEW PACKAGE WITH THE NAME PRESENTATION :->
                    // 10.> Create a main view model in it.
                    // 11.> Create main state data class that will contain isLoading, search word, etc. type of variables.
                    // 12.> Now create main ui events that user can make.
                    // 13.> Now handle ui events using main state in view model.
                    // THAT'S IT FOR THE MVVM NOW WE WILL WORK ON UI.
                }
            }
        }
    }
}