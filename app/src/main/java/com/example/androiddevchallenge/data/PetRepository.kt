package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.Gender
import com.example.androiddevchallenge.Pet
import java.time.ZoneId
import java.time.ZonedDateTime

class PetRepository() {
    private val listOfPets = listOf(dog7, dog, dog3, pickle, dog4, dog5, dog6,
        dog, dog3, pickle, dog4, dog5, dog6)

    suspend fun getListPets(): List<Pet>
    {
        // FIXME IRL this would come from a server
        return listOfPets
    }

    suspend fun getPetById(id: String): Pet? {
        return listOfPets.find { it.id == id }
    }
}

val dog = Pet(
    "1",
    "Basil",
    "Basil is a bright, sensitive dog who enjoys play with his human family and responds well to training. As herders bred to move cattle, they are fearless and independent. They are vigilant watchdogs, with acute senses and a “big dog” bark. Families who can meet their bold but kindly Pembroke’s need for activity and togetherness will never have a more loyal, loving pet.",
    "https://images.unsplash.com/photo-1518378188025-22bd89516ee2?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1234&q=80",
    Gender.Male,
    2.2f,
    "Cross",
    "Main Road, Rosentenville, South Africa 🇿🇦",
    ZonedDateTime.of(2015, 2, 3, 8, 50, 0, 0, ZoneId.systemDefault())
)

val pickle = Pet(
    "2",
    "Pickle",
    "Pickle is a bright, sensitive dog who enjoys play with her human family and responds well to training. As herders bred to move cattle, they are fearless and independent. They are vigilant watchdogs, with acute senses and a “big dog” bark. Families who can meet their bold but kindly Pembroke’s need for activity and togetherness will never have a more loyal, loving pet.",
    "https://images.unsplash.com/photo-1598133894008-61f7fdb8cc3a?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1234&q=80",
    Gender.Female,
    2.5f,
    "Bulldog",
    "4th Avenue, Gauteng, South Africa 🇿🇦",
    ZonedDateTime.of(2015, 2, 3, 8, 50, 0, 0, ZoneId.systemDefault())
)

val dog3 =  Pet(
    "3",
    "Pippa",
    "Pickle is a bright, sensitive dog who enjoys play with his human family and responds well to training. As herders bred to move cattle, they are fearless and independent. They are vigilant watchdogs, with acute senses and a “big dog” bark. Families who can meet their bold but kindly Pembroke’s need for activity and togetherness will never have a more loyal, loving pet.",

    "https://images.unsplash.com/photo-1503256207526-0d5d80fa2f47?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1233&q=80",
    Gender.Male,
    3.0f,
    "Border Collie",
    "110 N 3th St, Brooklyn, NY, USA 🇺🇸",
    ZonedDateTime.of(2015, 2, 3, 8, 50, 0, 0, ZoneId.systemDefault())
)

val dog4 =  Pet(
    "4",
    "Coco",
    "Coco is a bright, sensitive dog who enjoys play with his human family and responds well to training. As herders bred to move cattle, they are fearless and independent. They are vigilant watchdogs, with acute senses and a “big dog” bark. Families who can meet their bold but kindly Pembroke’s need for activity and togetherness will never have a more loyal, loving pet.",

    "https://thehappypuppysite.com/wp-content/uploads/2019/03/Maltese-Lifespan-long.jpg",
    Gender.Female,
    3.2f,
    "Maltese Poodle",
    "110 N 3th St, Brooklyn, NY, USA 🇺🇸",
    ZonedDateTime.of(2015, 2, 3, 8, 50, 0, 0, ZoneId.systemDefault())
)

val dog5 =  Pet(
    "5",
    "Pixel",
    "Pixel is a bright, sensitive dog who enjoys play with his human family and responds well to training. As herders bred to move cattle, they are fearless and independent. They are vigilant watchdogs, with acute senses and a “big dog” bark. Families who can meet their bold but kindly Pembroke’s need for activity and togetherness will never have a more loyal, loving pet.",
    "https://www.pitbullinfo.org/uploads/7/8/9/7/7897520/american-bully-picture.jpg",
    Gender.Female,
    3.2f,
    "Pitbull",
    "171 Oxford Street, London, United Kingdom 🇬🇧",
    ZonedDateTime.of(2015, 2, 3, 8, 50, 0, 0, ZoneId.systemDefault())
)
val dog6 =  Pet(
    "6",
    "Finn",
    "Finn is a bright, sensitive dog who enjoys play with his human family and responds well to training. As herders bred to move cattle, they are fearless and independent. They are vigilant watchdogs, with acute senses and a “big dog” bark. Families who can meet their bold but kindly Pembroke’s need for activity and togetherness will never have a more loyal, loving pet.",
    "https://images.unsplash.com/photo-1504826260979-242151ee45b7?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1234&q=80",
    Gender.Male,
    1.5f,
    "Spaniel",
    "152 Cold Street, Stockholm, Sweden 🇸🇪",
    ZonedDateTime.of(2021, 2, 3, 8, 50, 0, 0, ZoneId.systemDefault())
)

val dog7 =  Pet(
    "6",
    "Nora",
    "Nora is a bright, sensitive dog who enjoys play with his human family and responds well to training. As herders bred to move cattle, they are fearless and independent. They are vigilant watchdogs, with acute senses and a “big dog” bark. Families who can meet their bold but kindly Pembroke’s need for activity and togetherness will never have a more loyal, loving pet.",
    "https://images.unsplash.com/photo-1519098901909-b1553a1190af?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2167&q=80",
    Gender.Female,
    1.5f,
    "Corgi",
    "110 N 3th St, Brooklyn, NY, USA 🇺🇸",
    ZonedDateTime.of(2021, 2, 3, 8, 50, 0, 0, ZoneId.systemDefault())
)
