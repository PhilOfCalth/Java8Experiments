# Goal
To illustrate how Java handles multiple dispatch, and compare it to a language that supports double dispatch. 

For use in Naimuri insight/blog post.

## Note
This represents the first time I have ever written or compiled C#, so it may be of a poor standard.
I just needed it to illustrate the point. I have checked in the compiled .exe file. If you wish to compile
or run the C# code yourself, this is what I did in Ubuntu world, using mono-complete:
```bash
sudo apt update
sudo apt install mono-complete
cd csharp #from this folder
mcs -out:SpaceSimulatorClient.exe *.cs
mono SpaceSimulatorClient.exe
```
