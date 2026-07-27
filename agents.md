# Vanilla Minecraft Source Code

This repository contains extracted copies of decompiled vanilla Minecraft source code under:
- `fabric/sources/26.2/` (Current target version)
- `fabric/sources/26.1/` (Previous version reference)

## What is this?
When updating mods to newer versions of Minecraft (e.g., migrating from 26.1 to 26.2), method signatures, fields, class locations, and hierarchies in the underlying game code frequently change. This directory acts as a local, fully searchable repository of the vanilla Minecraft codebase (both common and client-side logic).

> **Important for 26.2:** In Minecraft 26.2, several key client GUI and screen management responsibilities were refactored (e.g., `setScreen()` and `screen()` moved from `Minecraft` to `Gui`, while HUD rendering moved to `Hud`). Always check `fabric/sources/26.2/` for current implementation details.

## How to use it
As an AI Agent or developer, you can use these sources to investigate API changes and resolve compilation or mixin errors.

**Best Practices for Agents:**
1. **Search for references in the current version:** If you encounter an `InvalidInjectionException`, `NoSuchMethodError`, or missing symbol, use `grep_search` within `fabric/sources/26.2/` (or `fabric/sources/26.1/` for diffing) to find target classes and inspect method signatures/fields.
   * Example (current version): `grep_search(SearchPath="fabric/sources/26.2", Query="setScreen", MatchPerLine=true)`
   * Example (diffing against 26.1): `grep_search(SearchPath="fabric/sources/26.1", Query="setScreen", MatchPerLine=true)`
2. **Examine classes:** Once you find the target file, use `view_file` to inspect exact parameters, fields, annotations, and implementations to properly configure your Mixins or API calls.
3. **Trace logic:** You can trace how vanilla Minecraft implements specific mechanics by searching interfaces or base classes within `fabric/sources/26.2/` to understand intended usage in the current version.

*Note: The `fabric/sources/` directory is ignored by Git to prevent bloating the repository.*
