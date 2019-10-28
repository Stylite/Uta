# Uta
A simple Discord webhook wrapper written in Scala

## Installation
Add it to your build.sbt

```scala
resolvers += "jitpack" at "https://jitpack.io"
libraryDependencies ++= Seq(
  "com.github.stylite" % "uta" % "33cb1a48a5"
)
```

## Usage
```scala
import kaoru.Uta

object Example extends App {
    val uta = new Uta("Your webhook URL")
    uta.send(content = "This is a webhook message!")
}
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[ISC](https://choosealicense.com/licenses/isc/)
