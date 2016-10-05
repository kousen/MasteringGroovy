package mjg

import groovy.json.*

String apiKey = new File('rotten_tomatoes_apiKey.txt').text
String url = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apiKey=$apiKey"

def vampMovies = new JsonSlurper().parseText("$url&q=vampire".toURL().text)
// Each page returns 30 movies
assert 30 == vampMovies.movies.size()
// Print their titles and release years
vampMovies.movies.each { m -> println "${m.title} (${m.year})" }