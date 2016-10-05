package mjg

import com.google.gson.Gson
import mjg.entities.Movie;

import com.gmongo.GMongo;

GMongo mongo = new GMongo()
def db = mongo.getDB('movies')

println db.vampireMovies.find().count()
//db.vampireMovies.find(critics_consensus : ~/.*/).each { movie ->
//    println "$movie.id $movie.title : $movie.critics_consensus"
//    println Movie.fromJSON(movie)
//}
//
//def bs = db.otherMovies.findOne(title: 'Blazing Saddles')
//println bs
//println Movie.fromJSON(bs)

Gson gson = new Gson()
def movieJson = db.vampireMovies.findOne(title: 'Interview with the Vampire')
println gson.fromJson(movieJson.toString(), mjg.Movie)