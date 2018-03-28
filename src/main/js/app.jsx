import React from 'react';
import ReactDOM from 'react-dom';

class App extends React.Component {

    constructor() {
        super();
        this.state = {
            files: [],
            filterText: ''
        };
        this.handleFilterTextChange = this.handleFilterTextChange.bind(this);
    }

    componentDidMount() {
        fetch(`/api/files`)
            .then(result => result.json())
            .then(files => this.setState({files}))
            .catch((err) => {
                console.error('err', err);
            });
    }

    handleFilterTextChange(filterText) {
        this.setState({
            filterText: filterText
        });
    }

    render() {
        return (
            <div>
                <span className="text-center ">
                    <h5>File Statistic</h5>
                </span>
                <div className="container">
                    <br/>
                    <SearchBar filterText={this.state.filterText} onFilterTextChange={this.handleFilterTextChange}/>
                    <br/>
                </div>
                <div className="container col-md-12">
                    <FileList files={this.state.files} filterText={this.state.filterText}/>
                </div>
            </div>
        );
    }
};

class SearchBar extends React.Component {
    constructor(props) {
        super(props);
        this.handleFilterTextChange = this.handleFilterTextChange.bind(this);
    }

    handleFilterTextChange(e) {
        this.props.onFilterTextChange(e.target.value);
    }

    render() {
        return (
            <form>
                <input type="text" placeholder="Search..."
                       value={this.props.filterText}
                       onChange={this.handleFilterTextChange}/>
            </form>
        );
    }
}

class FileList extends React.Component {
    render() {
        const filterText = this.props.filterText;
        var files = this.props.files
            .filter((file) => {
                return !(file.name.toLowerCase().indexOf(filterText.toLowerCase()) === -1);
            }
            ).map((file, i) => <File key={i} file={file}/>);
        return (
            <div className="table table-bordered left">
                <div className="btn btn-block row head">
                    <div className="col-md-1"><b>ID</b></div>
                    <div className="col-md-2"><b>FileName</b></div>
                </div>
                {files}
            </div>
        );
    }
};

class File extends React.Component {
    constructor() {
        super();
        /*this.clickHandler = this.clickHandler().bind(this);*/
        this.state = {isShowDetail: false};
    }

    clickHandler() {
        this.setState({isShowDetail: !this.state.isShowDetail});
    };

    render() {
        return (
            <div>
                <div className="btn btn-block row" onClick={this.clickHandler.bind(this)}>
                    <div className="col-md-1">{this.props.file.id}</div>
                    <div className="col-md-2">{this.props.file.name}</div>
                </div>
                {this.state.isShowDetail && <div className="container">
                    <FileStatistic fileId={this.props.file.id}/>
                </div>}
            </div>
        );
    }
};

class FileStatistic extends React.Component {
    constructor() {
        super();
        this.clickHandler = this.clickHandler.bind(this);
        this.state = {
            fileStat: [],
            buttonName: "Show line detail",
            isShowLineDetail: false};
    }

    componentDidMount() {
        fetch(`/api/files/` + this.props.fileId + '/stat')
            .then(result => result.json())
            .then(fileStat => this.setState({fileStat}))
            .catch((err) => {
                console.error('err', err);
            });
    }

    clickHandler() {
        this.setState({isShowLineDetail: !this.state.isShowLineDetail});
        this.setState({buttonName: this.state.isShowLineDetail
                ? "Show line detail"
                : "Hide line detail"
            });
    };

    eachItem(item, i) {
        return (
            <tr key={item.id}>
                <td>{item.longestWord}</td>
                <td>{item.shortestWord}</td>
                <td>{item.linesLength}</td>
                <td>{item.averageWordLength}</td>
                <td>
                    <button className="btn btn-info"
                            onClick={this.clickHandler.bind(this)}>{this.state.buttonName}</button>
                </td>
            </tr>
        );
    }

    render() {
        return (
            <div>
                <table className="table table-bordered">
                    <thead>
                    <tr>
                        <th>Longest Word</th>
                        <th>Shortest Word</th>
                        <th>Lines Length</th>
                        <th>Average Word Length</th>
                        <th>Show Line Detail</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.fileStat.map(this.eachItem.bind(this))}
                    </tbody>
                </table>
                <br/>
                {this.state.isShowLineDetail && <div className="container">
                    <FileLineStatistic fileId={this.props.fileId}/>
                </div>}
            </div>
        );
    }
};

class FileLineStatistic extends React.Component {
    constructor() {
        super();
        this.state = {lineStat: []};
    }

    componentDidMount() {
        fetch(`/api/files/` + this.props.fileId + '/lines_stat')
            .then(result => result.json())
            .then(lineStat => this.setState({lineStat}))
            .catch((err) => {
                console.error('err', err);
            });
    }

    eachItem(item, i) {
        return (
            <tr key={item.id}>
                <td>{item.lineNumber}</td>
                <td>{item.longestWord}</td>
                <td>{item.shortestWord}</td>
                <td>{item.lineLength}</td>
                <td>{item.averageWordLength}</td>
            </tr>
        );
    }

    render() {
        return (
            <table className="table table-bordered">
                <thead>
                <tr>
                    <th>Line Number</th>
                    <th>Longest Word</th>
                    <th>Shortest Word</th>
                    <th>Line Length</th>
                    <th>Average Word Length</th>
                </tr>
                </thead>
                <tbody>
                {this.state.lineStat.map(this.eachItem)}
                </tbody>
            </table>
        );
    }
};

ReactDOM.render(<App/>, document.getElementById('react'));