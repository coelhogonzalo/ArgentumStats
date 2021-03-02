package com.coelhogonzalo.argentumstats.utils

object Constants {

    const val DATABASE_NAME: String = "ArgentumStats.db"

    //RACES
    const val HUMAN = "human"
    const val ELF = "elf"
    const val DARKELF = "darkelf"
    const val DWARF = "dwarf"
    const val GNOME = "gnome"
    //CLASSES
    const val CLERIC = "cleric"
    const val BARD = "bard"
    const val racesJson = """
    {
      "human":{
        "name": "human",
        "initial_health": 90,
        "intelligence": 18
      },
      "elf":{
        "name": "elf",
        "initial_health": 70,
        "intelligence": 20
      },
      "darkelf":{
        "name": "darkelf",
        "initial_health": 70,
        "intelligence": 20
      },
      "dwarf":{
        "name": "dwarf",
        "initial_health": 110,
        "intelligence": 17
      },
      "gnome":{
        "name": "gnome",
        "initial_health": 50,
        "intelligence": 21
      }
    }
    """
    const val rpgClassesJson = """
       {
       "mage":{
           "name": "mage",
           "health_increases": [3,4,5,6] ,
           "magic_power": 2
       },
       "paladin":{
           "name": "paladin",
           "health_increases": [5,6,7,8] ,
           "magic_power": 0.5
       },
       "cleric":{
           "name": "cleric",
           "health_increases": [4,5,6,7] ,
           "magic_power": 1
       },
       "warrior":{
           "name": "warrior",
           "health_increases": [6,7,8,9] ,
           "magic_power": 0
       }
    }
    """
}