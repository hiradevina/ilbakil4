package bangkit.mobiledev.hira.ilbakilseason4.data

import bangkit.mobiledev.hira.ilbakilseason4.R

data class Member(
    val name: String = "",
    val knownAs: String = "",
    val description: String = "",
    val img: Int = 0,
    val color: Int = R.color.black,
    val url: String = "https://google.com"
)