package com.example.validation_algorithm

fun countVietnameseLetters(latinString: String): Int {
    var count = 0
    val validPairs = mapOf(
        "aw" to "ă",
        "aa" to "â",
        "dd" to "đ",
        "ee" to "ê",
        "oo" to "ô",
        "ow" to "ơ",
        "w" to "ư",
    )
    val validKey = listOf("a","u","o")
    for (i in latinString.indices) {
        // Xử lý trường hợp đặc biệt: w
        if(i>0){
            if (latinString[i] == 'w'&& !validKey.any{it == latinString[i-1].toString()}) {
                count++
                continue
            }

        }else{
            if (latinString[i] == 'w') {
                count++
                continue
            }
        }
        // Kiểm tra cặp chữ cái hợp lệ
        if (i + 1 < latinString.length && validPairs.containsKey(latinString.substring(i, i + 2))) {
            count++
        }

    }
    return count
}

fun main() {
    val latinString = "hfdawhwhcoomdd"
    val numLetters = countVietnameseLetters(latinString)
    println("Số lượng chữ cái Tiếng Việt: $numLetters")
}