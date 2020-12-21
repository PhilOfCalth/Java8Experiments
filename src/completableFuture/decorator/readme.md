# Goal
Pair CompletableFuture with the Gang of Four design pattern Decorator, accepting the caveat that each decorator is
required to make some type of network call to complete. See if we can create any time saving.

For use in Naimuri insight/blog post:
https://www.naimuri.com/java8_decorator/

# Implementation Notes

## Validity of this Test
The premise, I admit, is a little weak, not being a very realistic example. Use of sleep to simulate network calls is
obviously not going to be 100%. Actual time savings will depend on the actual actions taken by CompletableFuture and the
order in which the decorators are layered, but you can see how the overall time should not be much longer that the time
taken to complete the most complex decorator’s network call.

## Java Inheritance Model vs Decorator
The example in the GoF book builds the abstract class Decorator with a constructor, which takes in the Component
interface (VisualComponentInterface in my implementation). However, Java's inheritance model does not allow for
overriding constructors, so I just left a protected instance variable of type VisualComponentInterface in the abstract
class, thus allowing concrete  subclasses to determine how they wish to inject this value. Of course in my example I 
used constructor injection, to stick closely to the text.

## Elements Cut From The GoF Example
The book's example VisualComponent interface has 2 functions, Draw and Resize. I started down the path of recreating
this, but quickly realised I was doubling the amount of effort required without engaging my goal. It would not change how
I would test the usability of Completable future.

The book uses this extra method to illustrate that fact that you do not need to override all the functions in the
interface(Component or VisualComponentInterface in my case) as the abstract class (Decorator) does this work for you.

## Methods Passed to supplyAsync
The question here is to lambda or not to lambda. As a personal rule of thumb, if the function is more than three lines
long, then I feel it should be a method and not a lambda. Your mileage may vary. For my example I thought that if this
was a real example, that code would be a lot more complex than it is, so I pulled it out into its own method.

### Static vs Non-Static
In really, both of my examples would probably depend on some elements of their concrete decorators' interior state, and
thus require to be non-static. In the actual code, neither do, so they could both be static. I made one of each type to
see how/if it would work. Remember, what I'm doing here is playing with CompletableFuture!

## Findings
1. Methods passed to CompletableFutures must be completely independent to the rest of the code.
2. Significant time savings are available for the right use case of CompletableFutures.
