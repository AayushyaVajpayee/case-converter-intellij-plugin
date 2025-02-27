# Snake Case to Camel Case Converter

An IntelliJ Platform plugin that converts snake_case text to camelCase with a simple keyboard shortcut.

## Features

- Converts selected snake_case text to camelCase instantly
- Smart conversion: only modifies text containing underscores (`_`)
- Works with multiple selections and multi-line text
- Preserves text that doesn't contain underscores
- Simple keyboard shortcut: `Alt+Shift+C` (Windows/Linux) or `Option+Shift+C` (macOS)

## Installation

### Manual Installation

1. Download the latest release `.zip` file from the [Releases](https://github.com/yourusername/snake-to-camel/releases) page
2. In your JetBrains IDE, go to Settings/Preferences → Plugins
3. Click the gear icon ⚙️ and select "Install Plugin from Disk..."
4. Select the downloaded `.zip` file
5. Restart your IDE when prompted

## Usage

1. Select text containing snake_case identifiers in your editor
2. Press `Alt+Shift+B` (Windows/Linux) or `Option+Shift+B` (macOS)
3. The selected text will be converted to camelCase (only parts containing underscores will be modified)

### Examples:

- `user_name` → `userName`
- `database_connection_string` → `databaseConnectionString`
- `mixed text with user_id and name` → `mixed text with userId and name`
- `alreadyCamel` → `alreadyCamel` (unchanged)

### Custom Shortcut

To change the keyboard shortcut:
1. Go to Settings/Preferences → Keymap
2. Search for "Convert Snake Case to Camel Case"
3. Right-click on it and select "Add Keyboard Shortcut"
4. Press your desired key combination
5. Click OK to save

## Building from Source

Prerequisites:
- Java JDK 11 or later
- Gradle 7.3 or later

Steps:
1. Clone the repository
   ```
   git clone https://github.com/yourusername/snake-to-camel.git
   cd snake-to-camel
   ```

2. Build the plugin
   ```
   ./gradlew buildPlugin
   ```

3. The plugin zip file will be created in `build/distributions/`

## Compatibility

- IntelliJ IDEA 2022.3 or later
- Other JetBrains IDEs based on the same platform (PyCharm, WebStorm, etc.)

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.