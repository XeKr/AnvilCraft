#version 150

in vec4 vertexColor;

uniform vec4 ColorModulator;
uniform vec2 Center;
uniform float InnerDiameter;
uniform float OuterDiameter;
uniform float AntiAliasingRadius;

out vec4 fragColor;

void main() {
    float distance = distance(gl_FragCoord.xy, Center);
    vec4 color = vec4(0, 0, 0, 0);

    if (distance <= OuterDiameter + AntiAliasingRadius && distance >= InnerDiameter - AntiAliasingRadius) {
        color = vertexColor;
    }

    if (distance >= InnerDiameter - AntiAliasingRadius && distance <= InnerDiameter + AntiAliasingRadius) {
        color.a *= smoothstep(InnerDiameter - AntiAliasingRadius, InnerDiameter + AntiAliasingRadius, distance);
    } else if (distance >= OuterDiameter - AntiAliasingRadius && distance <= OuterDiameter + AntiAliasingRadius) {
        color.a *= smoothstep(OuterDiameter + AntiAliasingRadius, OuterDiameter - AntiAliasingRadius, distance);
    }

    fragColor = color * ColorModulator;
}