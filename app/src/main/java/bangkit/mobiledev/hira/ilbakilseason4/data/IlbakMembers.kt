package bangkit.mobiledev.hira.ilbakilseason4.data

import bangkit.mobiledev.hira.ilbakilseason4.R

object IlbakMembers {
    private val memberNames = arrayOf(
        "Ravi / 라비",
        "Dindin / 딘딘",
        "Kim Seonho / 김선호",
        "Moon Seyoon / 문새운",
        "Kim Jongmin / 김종민",
        "Yeon Junghoon / 연정훈",
        "Bang Geulyi / 방글이",
        "Single / 싱글이",
        "Dinosaur / 공룡",
        "The Staff"
    )

    private val memberAlias = arrayOf(
        "The maknae, Ravirman, traitor #3",
        "Dindin the Kid, Tenacious Dindin, Upper Teeth Dindin",
        "Rookie Variety, Trainer Sergeant Kim, Mirror Brother #2, Traitor #2",
        "Dancing Fatty, Moon Shrimp, Chubby Tom",
        "Variety Show fossil, Kim Jongmyeon, Traitor #1, Mirror Brother #1",
        "Passion Junghoon, The National Thief, The Oldest Hyung",
        "Bang PD, Smiley PD, (not) Nucksal",
        "Stress",
        "Season 4 Mascott",
        "Staff and Crew"
    )

    private val memberDescription =
        arrayOf(
            "The youngest of the 6. The fastest member, and the coolest when he is on the stage, his regular job. Very competitive, but lost more often. \"I'm smart, but I'm dumb. I'm dumb, but I'm smart.\"",
            "The smallest member of the 6. Shows only his upper teeth when he is happy. Sulks every time someone does bad to him, but regularly annoys his brothers. Would do anything to sleep indoor. Notably tenacious when outcoming staff's plan.",
            "The luckiest member of the 6. Would ask the instruction twice most of the time. Is fast and strong but would be drained after dinner time. Paying a yearly rent for sleeping outdoor.",
            "The fattest member of the 6. Love talking so much it makes the other members' ears bleed. Is very strong and frightening you would fall first before he even moves. Secretly the one who keeps the pace of the group and is very attentive to every staff and member.",
            "(Should be) The ace member of the 6. But often lose because caught doing cheap trick. Would ask the instruction twice but still doesn't understand later. Always ready with a toothpaste and toothbrush in belongings.",
            "The dad of the 6. Is very focused on every mission. Rarely lost and doesn't make mistakes, except for Jegi. Would swear with his stares if someone made him angry, but actually the wisest and nicest hyung. Loves his wife so much to the point he wouldn't be here without his wife blessing.",
            "The boss of the members. Is very strict the members would not wish to mess with her. In love with dinosaurs. Very supportive towards the member and is actually warm hearted",
            "Was first introduced on Stress Free Special to accompany Jongmin as the Stress King. Is named Single afterwards by Seonho because Jongmin's stress on relationship. Would bring badluck according to the members.",
            "Would appear anywhere even on a deserted island because Bang Geulyi's love towards the species. Could be in anyform from a balloon costume, a egg-like balloon, posters, to a 16 meter statue.",
            "The most important part of the show. Are very hardworking and creative even during hard times. Are competitive if challenged by the members."
        )

    private val memberImages = arrayOf(
        R.drawable.kws,
        R.drawable.lc,
        R.drawable.ksh,
        R.drawable.msy,
        R.drawable.kjm,
        R.drawable.yjh,
        R.drawable.bgy,
        R.drawable.single,
        R.drawable.dinosaur,
        R.drawable.ts
    )

    private val memberColors = arrayOf(
        R.color.wonsik,
        R.color.dindin,
        R.color.seonho,
        R.color.seyoon,
        R.color.jongmin,
        R.color.junghoon,
        R.color.purple_500,
        R.color.purple_500,
        R.color.purple_500,
        R.color.purple_500,
    )

    private val memberUrl = arrayOf(
        "https://music.youtube.com/channel/UCx50BaiZtoiRSAioQu0ogWQ",
        "https://music.youtube.com/channel/UC0MO1Fh-_3M8v7Aa5MLLsEw",
        "https://g.co/kgs/MFcJde",
        "https://g.co/kgs/mFLjD4",
        "https://music.youtube.com/channel/UC6crVQ5uz9pzRkvqHF8xvXA",
        "https://g.co/kgs/NoNnMd",
        "https://youtube.com/playlist?list=PLMf7VY8La5RHuqYC9t6GcbapEGvrs1pQ3",
        "https://www.youtube.com/watch?v=dolssPYVO1Q",
        "https://www.youtube.com/watch?v=K97KqfCDYLE&t=12s",
        "https://www.youtube.com/watch?v=rULI6iiCSp8"
    )

    val ilbakMemberList: ArrayList<Member>
        get() {
            val list = arrayListOf<Member>()
            for (position in memberNames.indices) {
                val member = Member(
                    description = memberDescription[position],
                    name = memberNames[position],
                    knownAs = memberAlias[position],
                    img = memberImages[position],
                    color = memberColors[position],
                    url = memberUrl[position]
                )
                list.add(member)
            }
            return list
        }
}