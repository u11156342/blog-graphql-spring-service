 
you can go to http://localhost:8080/graphiql.
run:
mutation Person {
addNote(note:{note:"xxxx"}  ,author : {name:"aeqeqeqdadadad",email:"adad"} ) {
id
}
}
then in another tab on the same url
subscription test {
notes {
createdOn
authorName
}
}