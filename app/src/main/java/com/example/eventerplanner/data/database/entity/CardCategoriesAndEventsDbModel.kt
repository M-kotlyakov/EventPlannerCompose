package com.example.eventerplanner.data.database.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

// TODO: тема такая, что Entity не могут иметь отношений. Нужно как-то переделать
/*@Entity(tableName = "card_categories_and_events")
data class CardCategoriesAndEventsDbModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @Embedded val cardCategoriesDbModel: CardCategoriesDbModel,
    @Relation(
        parentColumn = "cardCategoriesId",
        entityColumn = "categoriesParentId",
        entity = EventDbModel::class
    )
    val eventList: List<EventDbModel>
)*/
