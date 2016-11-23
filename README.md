# Free Monad in Cats sample implementation

This is a forked repository from [here](https://github.com/feynmanliang/cats-logo).

It contains the source code from [Overview of free monad in cats](http://blog.scalac.io/2016/06/02/overview-of-free-monad-in-cats.html).

## Alternative implementation

In the package `alt` I tried an alternative approach with monad stacks and DI with partial application: 

It might be quite as good for many use cases that don't necessarily need the interpreter pattern?

In my opinion it still has many of the benefits of the free monad approach:

* Good for managing side effects in a consistent way
* Less boiler-plate
* Easier to understand because it doesn't need natural transformations
* More explicit because it needs less implicits
* Composable / testable / scalable
