import { BackgroundLocation } from 'background-location';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    BackgroundLocation.echo({ value: inputValue })
}
