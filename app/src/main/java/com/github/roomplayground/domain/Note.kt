package com.github.roomplayground.domain

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
@Entity(tableName = "notes")
data class Note @ParcelConstructor constructor(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var text: String,
    var date: String
)