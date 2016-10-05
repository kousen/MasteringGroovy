package mjg

import groovy.json.*

String key = new File('rotten_tomatoes_apiKey.txt').text
String base = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?"
String qs = [
        apiKey: key,
        q     : URLEncoder.encode('Blazing Saddles', 'UTF-8')].collect { k, v ->
    "$k=$v"
}.join('&')
String url = "$base$qs"
String jsonTxt = url.toURL().text
println JsonOutput.prettyPrint(jsonTxt)
def json = new JsonSlurper().parseText(jsonTxt)

def movie = json.movies[0]
def allCast = new JsonSlurper().parseText("${movie.links.cast}?apiKey=$key".toURL().text)
println '---------- All Cast ----------'
allCast.cast.each { println it }
println '------------------------------'
assert allCast.cast.find { it.characters =~ /Mongo/ }
