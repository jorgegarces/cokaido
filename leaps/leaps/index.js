function leaps(n){
    if(!(n%4) && !(n%100) && !(n%400)) return true
    if(!(n%4) && !(n%100)) return false
    if(!(n%4)) return true
    return false
}

module.exports = leaps