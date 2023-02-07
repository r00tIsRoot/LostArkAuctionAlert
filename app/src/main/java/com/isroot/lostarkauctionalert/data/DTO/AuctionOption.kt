package com.isroot.lostarkauctionalert.data.DTO

data class AuctionOption(
    val MaxItemLevel: Int,
    val ItemGradeQualities: Int,
    val SkillOptions: List<SkillOption>,
    val EtcOptions: List<EtcOption>,
    val Categories: List<Category>,
    val ItemGrades: List<String>,
    val ItemTiers: List<Int>,
    val Classes: List<String>,
)