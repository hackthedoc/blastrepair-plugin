# BlastRepair Plugin

Minecraft Plugin to repair blast explosions automatically.

Works for 1.21+ at least.
> There was no test on prior versions

## Features

- repairal can be turned on/off
- repairal speed and start delay are customizable
- possible to turn on and off the repairs based on the origin of the explosion

## Commands

- `/blastrepair <on|off|reload>`

## Permissions

- `blastrepair.admin` : given to all operators by default

## Installation

1. Download the plugin jar file.
2. Place it in the `plugins` folder of your server.
3. Restart the server.
4. Configure the `config.yml` file if necessary.

## Configuration

You can modify the `config.yml` file but be careful not to remove any variables.

```yaml
# are repairals enabled or not
enabled: true     

# Delay before the repair starts (in seconds)
delay: 1         

# time between each block (in seconds)
repair-speed: 0.2

# activate/deactvate repairal based on the explosion type
explosion-types:
  creeper: true
  tnt: true
  ghast: true
  bed: true
  wither: true
  lightning: true
```

