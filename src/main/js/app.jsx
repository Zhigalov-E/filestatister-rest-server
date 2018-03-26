import React from 'react';
import ReactDOM from 'react-dom';


class FileTable extends React.Component {
    render() {
        var rows = [];
        this.props.files.map((file) =>
            rows.push(<File file={file}/>)
        );
        return (
            <div className="container">
                <table className="table table-striped">
                    <thead>
                    <tr key={0}>
                        <th>FileName</th>
                        <th>Path</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>{rows}</tbody>
                </table>
            </div>
        );
    }
};

class File extends React.Component {
    constructor() {
        super();
        this.state = {
            fileStatVisible: false
        }
    }

    handleDetail() {
        this.setState({fileStatVisible: !this.state.fileStatVisible});
        {
            this.state.fileStatVisible
                ? <Child />
                : null
        }
    }

    render() {
        return (

                    <tr key={this.props.file.id} >
                        <td> {this.props.file.name} {this.props.file.id}</td>
                        <td> {this.props.file.path}</td>
                        <td>
                            <button className="btn btn-info" onClick={this.handleDetail}>Show detail</button>
                        </td>
                    </tr>
                    /*{
                        this.state.fileStatVisible
                            ? <FileStatistic />
                            : null
                    }*/

        );
    }
};

class FileStatistic extends React.Component {
    constructor() {
        super();
    }

    render() {
        return(
            <div className="container">
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th>LongestWord</th>
                            <th>ShortestWord</th>
                            <th>LinesLength</th>
                            <th>AverageWordLength</th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        )
    }

    onClick() {
        this.setState({fileStatVisible: !this.state.fileStatVisible});
    }
};

class App extends React.Component {

    constructor() {
        super();
        this.state = {files: []};
    }

    componentDidMount() {
        fetch(`http://localhost:8080/api/files`)
            .then(result => result.json())
            .then(files => this.setState({files}))
    }

    render() {
        return (<FileTable files={this.state.files}/>);
    }
};

ReactDOM.render(<App/>,
    document.getElementById('react')
);


/*
var cols = [
    { key: 'firstName', label: 'First Name' },
    { key: 'lastName', label: 'Last Name' }
];

var data = [
    { id: 1, firstName: 'John', lastName: 'Doe' },
    { id: 2, firstName: 'Clark', lastName: 'Kent' }
];

var Table = React.createClass({

    render: function() {
        var headerComponents = this.generateHeaders(),
            rowComponents = this.generateRows();

        return (
            <table>
                <thead> {headerComponents} </thead>
                <tbody> {rowComponents} </tbody>
            </table>
        );
    },

    generateHeaders: function() {
        var cols = this.props.cols;  // [{key, label}]

        // generate our header (th) cell components
        return cols.map(function(colData) {
            return <th key={colData.key}> {colData.label} </th>;
        });
    },

    generateRows: function() {
        var cols = this.props.cols,  // [{key, label}]
            data = this.props.data;

        return data.map(function(item) {
            // handle the column data within each row
            var cells = cols.map(function(colData) {

                // colData.key might be "firstName"
                return <td> {item[colData.key]} </td>;
            });
            return <tr key={item.id}> {cells} </tr>;
        });
    }
});*/
