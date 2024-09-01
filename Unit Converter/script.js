function createTabs() {
    const tabsContainer = document.createElement('div');
    tabsContainer.className = 'tabs';

    const tabs = [
        { id: 'length', label: 'Length' },
        { id: 'weight', label: 'Weight' },
        { id: 'temperature', label: 'Temperature' }
    ];

    tabs.forEach(tab => {
        const button = document.createElement('button');
        button.textContent = tab.label;
        button.setAttribute('data-tab', tab.id);
        button.onclick = () => showTab(tab.id);
        tabsContainer.appendChild(button);
    });

    document.querySelector('.container').appendChild(tabsContainer);
}

function createConverterTabs() {
    createConverterTab('length', 'Length', [
        { value: 'ft', text: 'Feet' },
        { value: 'm', text: 'Meters' },
        { value: 'in', text: 'Inches' },
        { value: 'cm', text: 'Centimeters' }
    ]);

    createConverterTab('weight', 'Weight', [
        { value: 'lb', text: 'Pounds' },
        { value: 'kg', text: 'Kilograms' },
        { value: 'g', text: 'Grams' },
        { value: 'oz', text: 'Ounces' }
    ]);

    createConverterTab('temperature', 'Temperature', [
        { value: 'C', text: 'Celsius' },
        { value: 'F', text: 'Fahrenheit' },
        { value: 'K', text: 'Kelvin' }
    ]);
}

function createConverterTab(id, title, units) {
    const container = document.createElement('div');
    container.id = id;
    container.className = 'tab-content';

    const heading = document.createElement('h2');
    heading.textContent = title;
    container.appendChild(heading);

    const input = document.createElement('input');
    input.type = 'text';
    input.id = `${id}-value`;
    input.placeholder = 'Enter value';
    container.appendChild(input);

    const fromSelect = document.createElement('select');
    fromSelect.id = `${id}-from`;
    units.forEach(unit => {
        const option = document.createElement('option');
        option.value = unit.value;
        option.textContent = unit.text;
        fromSelect.appendChild(option);
    });
    container.appendChild(fromSelect);

    const toSelect = document.createElement('select');
    toSelect.id = `${id}-to`;
    units.forEach(unit => {
        const option = document.createElement('option');
        option.value = unit.value;
        option.textContent = unit.text;
        toSelect.appendChild(option);
    });
    container.appendChild(toSelect);

    const button = document.createElement('button');
    button.textContent = 'Convert';
    button.onclick = () => {
        const value = parseFloat(document.getElementById(`${id}-value`).value);
        if (isNaN(value)) {
            document.getElementById(`${id}-result`).textContent = 'Please enter a valid number.';
            return;
        }
        const from = document.getElementById(`${id}-from`).value;
        const to = document.getElementById(`${id}-to`).value;
        const result = convertUnits(value, from, to, id);
        if (typeof result === 'string') {
            document.getElementById(`${id}-result`).textContent = result;
        } else {
            document.getElementById(`${id}-result`).textContent = `${value} ${from} = ${result} ${to}`;
        }
    };
    container.appendChild(button);

    const result = document.createElement('p');
    result.id = `${id}-result`;
    container.appendChild(result);

    document.querySelector('.container').appendChild(container);
}

function init() {
    const container = document.querySelector('.container');

    const title = document.createElement('h1');
    title.textContent = 'Unit Converter';
    container.appendChild(title);
    createTabs();
    createConverterTabs();
    showTab('length');
}

window.onload = init;

function showTab(tabName) {
    const tabs = document.querySelectorAll('.tab-content');
    tabs.forEach(tab => {
        if (tab.classList.contains('active')) {
            const input = tab.querySelector('input');
            const result = tab.querySelector('p');
            const selects = tab.querySelectorAll('select');
            if (input) input.value = '';
            if (result) result.textContent = '';
            selects.forEach(select => select.selectedIndex = 0);
        }
        tab.classList.remove('active');
    });
    document.getElementById(tabName).classList.add('active');

    const tabButtons = document.querySelectorAll('.tabs button');
    tabButtons.forEach(button => button.classList.remove('active'));

    const activeButton = document.querySelector(`.tabs button[data-tab="${tabName}"]`);
    if (activeButton) {
        activeButton.classList.add('active');
    }
}

function convertUnits(value, from, to, type) {
    const conversionFactors = {
        length: {
            'ft-ft': value => value,
            'ft-m': value => value * 0.3048,
            'm-ft': value => value / 0.3048,
            'ft-in': value => value * 12,
            'in-ft': value => value / 12,
            'ft-cm': value => value * 30.48,
            'cm-ft': value => value / 30.48,
            'm-m': value => value,
            'm-in': value => value * 39.3701,
            'in-m': value => value * 0.0254,
            'in-in': value => value,
            'in-cm': value => value * 2.54,
            'cm-in': value => value / 2.54,
            'm-cm': value => value * 100,
            'cm-m': value => value / 100,
            'cm-cm': value => value
        },
        weight: {
            'lb-lb': value => value,
            'lb-kg': value => value * 0.453592,
            'kg-lb': value => value / 0.453592,
            'lb-oz': value => value * 16,
            'oz-lb': value => value / 16,
            'kg-kg': value => value,
            'kg-oz': value => value * 35.274,
            'oz-kg': value => value / 35.274,
            'g-g': value => value,
            'oz-g': value => value * 28.3495,
            'g-oz': value => value / 28.3495,
            'lb-g': value => value * 453.592,
            'g-lb': value => value / 453.592,
            'kg-g': value => value * 1000,
            'g-kg': value => value / 1000,
            'oz-oz': value => value
        },
        temperature: {
            'C-C': value => value,
            'C-F': value => (value * 9 / 5) + 32,
            'F-C': value => (value - 32) * 5 / 9,
            'C-K': value => value + 273.15,
            'K-C': value => value - 273.15,
            'F-F': value => value,
            'F-K': value => (value - 32) * 5 / 9 + 273.15,
            'K-F': value => (value - 273.15) * 9 / 5 + 32,
            'K-K': value => value
        }
    };

    const key = `${from}-${to}`;
    if (conversionFactors[type] && conversionFactors[type][key]) {
        return conversionFactors[type][key](value);
    } else {
        return 'Conversion not available';
    }
}