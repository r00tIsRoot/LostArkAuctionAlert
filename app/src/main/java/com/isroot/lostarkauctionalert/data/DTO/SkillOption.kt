package com.isroot.lostarkauctionalert.data.DTO

data class SkillOption(
    val Value: Int,
    val Class: String,
    val Text: String,
    val IsSkillGroup: Boolean,
    val Tripods: List<Tripod>,
    )