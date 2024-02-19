package com.nticoding.electroluxassignment.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.nticoding.electroluxassignment.data.entity.Program
import com.nticoding.electroluxassignment.R.drawable as drawRes
import com.nticoding.electroluxassignment.R.string as strRes

class ProgramDataStore {
    private val programTable = listOf<Triple<@StringRes Int, @StringRes Int, @DrawableRes Int>>(
        Triple(
            first = strRes.cottons_program_title,
            second = strRes.cottons_program_description,
            third = drawRes.ic_cotton),
        Triple(
            first = strRes.cotton_eco_program_title,
            second = strRes.cotton_eco_program_description,
            third = drawRes.ic_cotton
        ),
        Triple(
            first = strRes.synthetics_program_title,
            second = strRes.synthetics_program_description,
            third = drawRes.ic_synthetics
        ),
        Triple(
            first = strRes.mixed_plus_program_title,
            second = strRes.mixed_plus_program_description,
            third = drawRes.ic_mixed
        ),
        Triple(
            first = strRes.delicates_program_title,
            second = strRes.delicates_program_description,
            third = drawRes.ic_delicates
        ),
        Triple(
            first = strRes.sports_program_title,
            second = strRes.sports_program_description,
            third = drawRes.ic_sport),
        Triple(
            first = strRes.bed_linen_extra_large_program_title,
            second = strRes.bed_linen_extra_large_program_description,
            third = drawRes.ic_bedding
        ),
    )

    fun getAllPrograms(): List<Program> {

        return programTable.map {
            Program(
                it.first,
                it.second,
                it.third
            )
        }
    }
}
