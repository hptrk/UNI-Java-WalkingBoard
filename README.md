# Java Walking Board Game

This project was developed as a **university assignment**, implementing a **turn-based board game** where players navigate a grid and collect points. The game features both regular players and a special "Buccaneer" player with unique movement patterns.

## 🎮 Game Features
- **Dynamic Game Board**: Configurable board size with scoring tiles.
- **Multiple Player Support**: Supports 2+ players per game.
- **Special Characters**: Features a unique "Maddy Rotating Buccaneer" player.
- **Score Tracking**: Tracks and calculates points for each player.
- **Direction System**: Implements a compass-like direction system (UP, RIGHT, DOWN, LEFT).

## 🔧 Technical Features
- **Object-Oriented Design**: Utilizes inheritance and encapsulation.
- **Test-Driven Development**: Comprehensive unit tests.
- **Modular Architecture**: Separated into player, board, and utility components.

## 📋 Class Structure
- `WalkingBoard`: Base game board implementation.
- `WalkingBoardWithPlayers`: Extended board with player management.
- `Player`: Base player class.
- `MaddyRotatingBuccaneer`: Special player type.
- `Direction`: Enum for movement directions.

## 🎲 Game Rules
- Players take turns moving on the board.
- Each tile has a base score of 3.
- Players collect points by moving over tiles.
- The Buccaneer rotates direction based on round count.
- Maximum score per step is 13 points.

## 📅 Project Details
- **University**: EITE
- **Year**: 2024
- **Language**: Java
- **Testing Framework**: Junit

## 🧪 Test Examples

```java
// Example game with 2 players
WalkingBoardWithPlayers board = new WalkingBoardWithPlayers(5, 2);
int[] stepCounts = {1, 3, 2, 1, 2, 2};
int[] points = board.walk(stepCounts);
// Player 1: 9 points
// Player 2: 18 points
```
---
⭐ This was a university project and is not actively maintained.
