package gjdk

// trivial username, password
String u = 'username'
String p = 'password'

// base 64 encoding
String encoded = "$u:$p".bytes.encodeBase64()
println "$u:$p -> $encoded"
assert encoded == 'dXNlcm5hbWU6cGFzc3dvcmQ='

// decoded with multiple returns
def (user,pass) = new String(encoded.decodeBase64()).split(':')
println "(user,pass) = ($user,$pass)"
assert user == u
assert pass == p
