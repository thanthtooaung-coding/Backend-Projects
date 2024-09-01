# Unit Converter

Unit Converter is a web-based application that allows users to convert between different units of measurement across various categories such as length, weight, and temperature. The application is designed for ease of use with an intuitive tabbed interface, making it simple to switch between different conversion types.

## Features

- **Tabbed Interface**: The application uses a tabbed interface to switch between different unit categories:
    - **Length**: Convert between units such as feet, meters, inches, and centimeters.
    - **Weight**: Convert between units such as pounds, kilograms, grams, and ounces.
    - **Temperature**: Convert between Celsius, Fahrenheit, and Kelvin.
- **Dynamic Conversion**: Enter a value, select the units you want to convert from and to, and get an instant result.
- **Reset on Tab Switch**: When switching between tabs, the input fields and results from the previous tab are automatically reset to ensure a clean start for new conversions.

## How to Use

### Running the Application

1. Open `index.html` in your web browser.

### Using the Tabs

1. **Select a Tab**: Click on the tab for the type of conversion you want to perform (Length, Weight, or Temperature).
2. **Enter a Value**: Input the value you want to convert in the provided input field.
3. **Choose Units**: Select the units you are converting from and to using the dropdown menus.
4. **Convert**: Click the "Convert" button to see the result.
5. **View Result**: The result will be displayed below the button in the format `[value] [from unit] = [result] [to unit]`.

### Switching Tabs

- When you switch to another tab, the input and result of the previous tab will be reset automatically.

## Error Handling

- **Invalid Input**: The application handles invalid inputs by not performing the conversion when the input is empty or non-numeric.

## Requirements

- A modern web browser (Chrome, Firefox, Safari, Edge)

## Installation

### Clone the Repository

```bash
git clone https://github.com/thanthtooaung-coding/Backend-Projects
```

### Navigate to the project directory:
```bash
cd Backend-Projects/Unit Converter
```

### Open the Application:
```bash
Simply open `index.html` in your preferred web browser.
```

## License
This project is licensed under the [MIT License](../LICENSE).